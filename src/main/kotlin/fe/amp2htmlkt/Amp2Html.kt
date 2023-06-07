package fe.amp2htmlkt

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Node
import java.io.File
import java.io.InputStream


object Amp2Html {
    fun getNonAmpLink(
        html: String,
        baseUri: String,
        referrer: String? = null,
    ) = parseHtml(Jsoup.parse(html, baseUri), baseUri, referrer)

    fun getNonAmpLink(
        stream: InputStream,
        baseUri: String,
        referrer: String? = null,
    ) = stream.use { parseHtml(Jsoup.parse(it, "utf-8", baseUri), baseUri, referrer) }

    private fun parseHtml(document: Document, location: String, referrer: String?): String? {
        val head = document.head()

        val ampLink = head.select("link[rel='amphtml'][href]").firstOrNull()
        val canonicalLink = head.select("link[rel='canonical'][href]").firstOrNull()
        val amp = document.select("html[amp],html[⚡]")

        if (amp.isNotEmpty() || (ampLink != null && ampLink.href() == location)) {
            if (canonicalLink != null && canonicalLink.href().isNotEmpty() && !(ampLink != null && ampLink.href() == canonicalLink.href())) {
                if (canonicalLink.href().isNotEmpty() && canonicalLink.href() != location && canonicalLink.href() != referrer) {
                    return canonicalLink.href()
                }
            }
        }

        return null
    }

    private fun Node.href() = attr("href")
}
