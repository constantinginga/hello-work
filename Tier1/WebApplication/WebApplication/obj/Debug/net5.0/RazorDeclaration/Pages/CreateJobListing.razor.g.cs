// <auto-generated/>
#pragma warning disable 1591
#pragma warning disable 0414
#pragma warning disable 0649
#pragma warning disable 0169

namespace WebApplication.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Web.Virtualization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using WebApplication;

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\_Imports.razor"
using WebApplication.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
using WebApplication.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
using WebApplication.Data;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/joblisting/create")]
    public partial class CreateJobListing : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
        }
        #pragma warning restore 1998
#nullable restore
#line 74 "C:\Users\micha\IdeaProjects\hello-work\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
           
        private JobListing jobListing = new JobListing();
        private List<string> jobRequirements = new List<string>(new string[3]);
        private List<string> jobPrivilleges = new List<string>(new string[3]);
        private DateTime ApplicationDate = new DateTime();

        private async void CreateNewJobListing()
        {
            jobListing.ApplicationDeadline = ApplicationDate.ToString("dd/MM/yyyy");
            jobListing.JobRequirments = jobRequirements;
            jobListing.JobPrivilleges = jobPrivilleges;
            await JobListingData.Create(jobListing);
            IList<JobListing> jbs = await JobListingData.GetJobListings();
            Console.WriteLine(jbs.Count);
            NavigationManager.NavigateTo("/");
        }
    

#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IJobListingData JobListingData { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager NavigationManager { get; set; }
    }
}
#pragma warning restore 1591
